// package The.Geeks.RESM.aspect;

// import org.apache.logging.log4j.Logger;
// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// public class LoggerAspect {
//     private static  Logger logger = Logger.getLogger(LoggerAspect.class);

//      @Pointcut("execution(*com.mighyjava.*.*.*(..))")
//      private void generalPointcut(){

//      }
//      @AfterThrowing(pointcut="generalPointcut() throws Exception ", throwing ="ex ")  
//      public void exceptionLog(JoinPoint joinPoint, Exception ex){
//         logger.error(joinPoint.getTarget().getClass().getSimpleName()+":"+joinPoint.getSignature()+":"+ex.getMessage());

//      } 

//      @Before ("generalPointcut()")
//      public void infolog(JoinPoint joinPoint){
//       logger.info(joinPoint.getTarget().getClass().getSimpleName()+":"+joinPoint.getSignature());
//      }
    
// }
