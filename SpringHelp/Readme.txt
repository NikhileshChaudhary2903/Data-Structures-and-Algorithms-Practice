1. Dependency Injection (Spring Config.xml config)

	<bean id="restaurantBean" class="org.nik.springtuts.Restaurant">
	<property name="welcomeNote" value="Welcome to my Shithole"></property>
	</bean>

 Restaurant class with welcomeNote as property/field

2. Constructor Injection

Injecting Dependency of one class with another eg Restaurant depends on Tea,Coffee ie HotDrink Class


	<bean id="restaurantBean" class="org.nik.springtuts.Restaurant">
	<constructor-arg ref="coffeeBean"></constructor-arg>
	</bean>
	
	<bean id="teaBean" class="org.nik.springtuts.Tea">
	</bean>
	
 	<bean id="coffeeBean" class="org.nik.springtuts.Coffee">
	</bean>

3.  Setter Injection

	<bean id="restaurantBean" class="org.nik.springtuts.Restaurant">
	<property name="drink" ref="teaBean"></property>
	</bean>
	
	<bean id="teaBean" class="org.nik.springtuts.Tea">
	</bean>
	
 	<bean id="coffeeBean" class="org.nik.springtuts.Coffee">
	</bean>
