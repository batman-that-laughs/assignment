# assignment
### Super Tokens
	Created an SDK - Demo
	Implemented the SDK with existing application - Patient
	To Run - 
	First build the SDK - 
		Step 1: run './gradlew build' in the demo folder - this will build the gradle project
		Step 2: run './gradlew build' in the patient folder - this will build the patient project
	Now run the application
		Step 3: run './gradlew bootRun' in the patient folder - this will run the spring-boot project
		Step 4: open: localhost:8080/swagger-ui/index.html - the swagger ui page
						on this page you will find the newly implemented api under sdk-demo-api-impl
	What does the API do - 
		It returns data populated by the SDK
	P.S: the dependency is injected assuming the availibilty of the SDK on specified file location, in order for the setup to work, place the demo and the patient folders under the same parent folder.
