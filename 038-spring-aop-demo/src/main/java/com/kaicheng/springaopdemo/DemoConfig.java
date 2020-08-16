package com.kaicheng.springaopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.kaicheng.springaopdemo")
public class DemoConfig {
	
	/**
	 * 
	 * Before advice: run before the method
	 * 
	 * After returning advice: run after the method(success execution)
	 * 
	 * After throwing advice: run after method(if exception thrown)
	 * 
	 * After finally advice: run after the method(finally)
	 * 
	 * Around advice: run before and after method
	 * 
	 * 
	 * 
	 * Pointcut Expression Language:
	 * 
	 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
	 * 		method-name-pattern(param-pattern) throws-pattern?)
	 * 
	 * The pattern is optional if it has "?"
	 * 
	 * Patterns can use wildcards(*) matches on everything
	 * 
	 * Match only addAccount() method in AccountDAO class
	 * @Before("execution(public void com.kaicheng.springaopdemo.dao.AccountDAO.addAccount())")
	 * 
	 * Match any addAccount() method in any class
	 * @Before("execution(public void addAccount())")
	 * 
	 * Match methods starting with add in any class
	 * @Before("execution(public void add*())")
	 * 
	 * 
	 * Match methods starting with processCreditCard in any class
	 * @Before("execution(public VerificationResult processCreditCard*())")
	 * 
	 * @Before("execution(* * processCreditCard*())") SAME AS @Before("execution(* processCreditCard*())")
	 * 
	 * 
	 * 
	 * For param-pattern:
	 * 	
	 * 		() - matches a method with no arguments
	 * 		(*) - matches a method with one argument of any type
	 * 		(..) - matches a method with 0 or more arguments of any type
	 * 
	 * Match addAccount methods with no arguments
	 * @Before("execution(* addAccount())")
	 * 
	 * Match addAccount methods that have Account param
	 * @Before("execution(* addAccount(com.kaicheng.springaopdemo.entity.Account))")
	 * 
	 * @Before("execution(* addAccount(com.kaicheng.springaopdemo.entity.Account, ..))")
	 * 
	 * Match addAccount methods with any number of arguments
	 * @Before("execution(* addAccount(..))")
	 * 
	 * 
	 * Match any method in our DAO package
	 * @Before("execution(* com.kaicheng.springaopdemo.dao.*.*(..))")
	 * 
	 * 
	 * 
	 * ***************************************
	 * 
	 * 
	 * @Pointcut("execution(* com.kaicheng.springaopdemo.dao.*.*(..))")
	 * public void forDaoPackage() {}
	 * 
	 * @Pointcut("execution(* com.kaicheng.springaopdemo.dao.*.get*(..))")
	 * public void getters() {}
	 * 
	 * @Pointcut("execution(* com.kaicheng.springaopdemo.dao.*.set*(..))")
	 * public void setters() {}
	 * 
	 * @Pointcut("forDaoPackage() && !(getter() || setter())")
	 * public void forDaoPackageNoGetterSetter() {}
	 * 
	 * @Before("forDaoPackageNoGetterSetter()")
	 * public void beforeAddAccountAdvice() {
	 * 	System.out.println("========Before");
	 * }
	 * 
	 * Remember if Pointcuts are not in the same class, we need to use fully
	 * qualified name, for example:
	 * 		@Before("com.kaicheng.springaopdemo.aspect.before.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
	 * 
	 * ******************************************
	 * 
	 * JoinPoint used to get method signature and args.
	 * 
	 * @Before("...")
	 * public void beforeAddAccountAdvicd(JoinPoint joinPoint) {
	 * 
	 * 		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
	 * 		System.out.println(methodSig);
	 * 
	 * 		Object[] args = joingPoint.getArgs();
	 * 		for (Object tempArg : args) {
	 * 			System.out.println(tempArg);
	 * 			if (tempArg instanceof Account) {
	 * 				Account account = (Account) tempArg;
	 * 				System.out.println(account);
	 * 			}
	 * 		}
	 * }
	 * 
	 * ************************************
	 * 
	 * @AfterReturning
	 * 
	 * @AferReturning(
	 * 	pointcut="execution(* com.kaicheng.springaopdemo.dao.AccountDAO.findAccounts(..))",
	 * 	returning="myResult" // stay consistent with myResult param in below signature
	 * )
	 * public void afterReturningFindAcountsAdvice(
	 * 	JoinPoint joinPoint, List<Account> myResult) {
	 * 
	 * 		String method = joinPoint.getSignature().toShortString();
	 * 
	 * 		System.out.println(myResult);
	 * 
	 *		// We can also modify the return myResult, and then return modified myResult to target method
	 *		for (Account tempAccount : myResult) {
	 *			String upperName = tempResult.getName().toUpperCase();
	 *			tempAccount.setName(upperName);
	 *		}
	 * 
	 * }
	 * ***************************************
	 * @AfterThrowing
	 * 
	 * @AfterThrowing(
	 * 	pointcut="execution(* com.kaicheng.springaopdemo.dao.AccountDAO.findAccounts(..))",
	 * 	throwing="myExc"
	 * )
	 * public void afterThrowingFindAccountsAdvice(
	 * 	JoinPoint joinPoint, Throwable myExc) {
	 * 		
	 * 		String method = joinPoint.getSignature().toShortString();
	 * 		System.out.println(method);
	 * 
	 * 		System.out.println(myExc);
	 * 
	 * }
	 * **************************************
	 * @After
	 * 
	 * @After will execute before @AfterThrowing
	 * 
	 * @After does not have access to the exception
	 * 
	 * 
	 * Starting with Spring 5.2.7:
	 * 
	 * -if advice methods defined in the same @Aspect class
	 *  that need to run at the same join point
	 * 
	 * -the @After advice method is invoked AFTER any @AfterReturning 
	 * or @AfterThrowing advice methods in the same aspect class
	 * 
	 * @After("execution(* com.kaicheng.springaopdemo.dao.AccountDAO.findAccounts(..))")
	 * public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
	 *
	 * 		String method = joinPoint.getSignature().toShortString();
	 * 		System.out.println(method);
	 * 
	 * }
	 * 
	 * ****************************************
	 * @Around
	 * 
	 * 
	 * @Around("execution(* com.kaicheng.springaopdemo.service.*.getFortune(..))")
	 * public Object aroundGetFortune(
	 * 	ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	 * 
	 * 		String method = proceedingJoinPoint.getSignature().toShortString();
	 * 		System.out.println(method);
	 * 
	 * 		long begin = System.currentTimeMillis();
	 * 		
	 * 		Object result = proceedingJoinPoint.proceed();
	 * 
	 * 		long end = System.currentTimeMillis();
	 * 
	 * 		long duration = end - begin;
	 * 
	 * 		System.out.println(duration);
	 * 
	 * 		return result;
	 * 
	 * }
	 * 
	 * 
	 *   //Handle Exception
	 *   
	 * @Around("execution(* com.kaicheng.springaopdemo.service.*.getFortune(..))")
	 * public Object aroundGetFortune(
	 * 	ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	 * 
	 * 		String method = proceedingJoinPoint.getSignature().toShortString();
	 * 		System.out.println(method);
	 * 
	 * 		long begin = System.currentTimeMillis();
	 * 
	 * 		Object result = null;
	 * 		
	 * 		try {
	 * 
	 * 			result = proceedingJoinPoint.proceed();
	 * 
	 * 		} catch (Exception e) {
	 * 			
	 * 			System.out.println(e);
	 * 			result = "Exception occurred! Default fortune;"
	 * 		}
	 * 
	 * 		long end = System.currentTimeMillis();
	 * 
	 * 		long duration = end - begin;
	 * 
	 * 		System.out.println(duration);
	 * 
	 * 		return result;
	 * 
	 * }
	 * 
	 *   // rethrow exc
	 *   
	 * @Around("execution(* com.kaicheng.springaopdemo.service.*.getFortune(..))")
	 * public Object aroundGetFortune(
	 * 	ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	 * 
	 * 		String method = proceedingJoinPoint.getSignature().toShortString();
	 * 		System.out.println(method);
	 * 
	 * 		long begin = System.currentTimeMillis();
	 * 
	 * 		Object result = null;
	 * 		
	 * 		try {
	 * 
	 * 			result = proceedingJoinPoint.proceed();
	 * 
	 * 		} catch (Exception e) {
	 * 			
	 * 			//rethrow exception
	 * 			throw e;
	 * 		}
	 * 
	 * 		long end = System.currentTimeMillis();
	 * 
	 * 		long duration = end - begin;
	 * 
	 * 		System.out.println(duration);
	 * 
	 * 		return result;
	 * 
	 * }
	 * 
	 * 
	 */

}
