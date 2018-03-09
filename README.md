MedMobile Test Applicaton
==========================

Spring boot application that saves data to postgres db via api calls. 

Portal url : http://localhost:8092/

View sample db data via get : http://localhost:8092/api/student

Save db data via post : http://localhost:8092/api/student

JSON Payload: 

{
	"rollNo":2,
	"name":"John Doe",
	"stream":"3B",
	"dateOfBirth":"1987-06-09",
	"totalMarks": 380
}