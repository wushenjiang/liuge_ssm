package com.liuge.ssm.controller;

import com.liuge.ssm.domain.SysLog;
import com.liuge.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName: LogAop
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/6/22  16:34
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private ISysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;
    // 开始时间
    private Date visitTime;
    // 访问的类
    private Class clazz;
    // 访问的方法
    private Method method;
    /**
     * 前置通知，主要是获取开始时间,执行的是哪个类，执行的是哪个方法
     * @param joinPoint
     */
   @Before("execution(* com.liuge.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
       // 当前时间就是开始访问的时间
       visitTime = new Date();
       // 具体要访问的类
       clazz = joinPoint.getTarget().getClass();
       // 获取访问的方法名
       String methodName = joinPoint.getSignature().getName();
       // 获取具体的执行的方法的对象
       Object[] args = joinPoint.getArgs();
       if (args == null || args.length == 0) {
           // 只能获取无参的方法
           method = clazz.getMethod(methodName);
       }else{
           Class[] classArgs =  new Class[args.length];
           for(int i=0;i<args.length;i++){
               classArgs[i] = args[i].getClass();
           }
           clazz.getMethod(methodName,classArgs);
       }

   }
    @After("execution(* com.liuge.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        long time  = System.currentTimeMillis() - visitTime.getTime();
        String url = "";
        // 获取url
        if(clazz != null && method != null && clazz != LogAop.class && clazz != SysLog.class){
            // 1.获取类上的RequestMapping注解的值
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                // 2.获取方法上的@RuquestMapping注解的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0]+methodValue[0];
                    // 获取访问的ip
                    String ip = request.getRemoteAddr();
                    // 获取当前操作的用户
                    // 从上下文获取当前登录的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    // 执行时长
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getName()+ " [方法名]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    //调用Service完成记录操作
                    sysLogService.save(sysLog);
                }
            }
        }
    }

}
