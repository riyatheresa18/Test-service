# Test-service

create a demo project using java springboot connected with postgres(docker image)

Swagger --> http://localhost:8080/swagger-ui/index.html

1. Implement a GET API to read the data from the DB and publish the report

APIs : GET All based on the toolName
	   GET All based on the eCus from specific toolName
	   GET All data by default

json format
[
{
"ecuName": "eATS1.6",
"versions": [
{
"toolName": "NEST",
"version": "B3-10-02-2022",
"passed": 1,
"failed": 3,
"total": 4
},
{
"toolName": "NEST",
"version": "B3-11-02-2022",
"passed": 5,
"failed": 2,
"total": 7
}
]
}
]

2.1. Develop an API - POST endpoint that will take the json file data as an input and push the data to DB

Report table:
ReportID
ToolName
Total Fail
Total Tests
Total Pass
ECUName
Tested version
Execution TimeStamp


