# RMIT SEPT 2020 Major Project

# Group 05

## Members
* Baker, Allan (s3718362)
* Ropkhop, Chiraporn (s3781279) - scrum master
* Do, Ngoc (s3698200)
* Abeysinghe, Kavin (s3756717)

## Records

* Github repository : https://github.com/RMIT-SEPT/majorproject-8-mon-17-30-5/
* ClickUp Workspace Sprint1: https://share.clickup.com/l/h/6k1rj-135/cfa825028cbc3ff
* ClickUp Workspace Sprint2: https://share.clickup.com/l/h/6-13306024-1/f0c937eeffefefa

## Milestone 2
* Github repository : https://github.com/RMIT-SEPT/majorproject-8-mon-17-30-5/tree/m2-circle-ci
This is the gitHub link for milestone2 submission
* ClickUp Workspace Sprint1: https://share.clickup.com/l/h/6k1rj-135/cfa825028cbc3ff
* ClickUp Workspace Sprint2: https://share.clickup.com/l/h/6-13306024-1/f0c937eeffefefa
* AWS RDS Endpoint: majorproject.cricml58bpuc.us-east-1.rds.amazonaws.com
This is using postgresql for the project tables
* AWS Elastic Beanstalk: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/
This is used for deploying backend
to use this, is the beanstalk url then follow by "/api/{usertype}/" follow by query syntax.
For example: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/worker/
Then result as lists of workers in the current database
* AWS S3: http://majorproject-sept.s3-website-us-east-1.amazonaws.com/
This is used for deploying frontend

## Milestone 3
* Github repository : https://github.com/RMIT-SEPT/majorproject-8-mon-17-30-5
* ClickUp Workspace Sprint1 : https://share.clickup.com/b/h/6-5580224-2/fae3d3e616d4aea
* AWS RDS Endpoint : 
* AWS ECS backend : 
to use this, is the beanstalk url then follow by "/api/{usertype}/" follow by query syntax.
For example: 
* AWS ECS front end : 
* Application : 

## Code documentation

[Quick Start](/docs/README.md) in `docs` folder

* Back End
AWS RDS for database
AWS ECR for backend docker image
AWS ECS for backend task


* Front end
AWS ECR for front end docker image
AWS ECS and Application Load balancer for front end task

## HOW TO SET UP

To set up the frontend, copy all the files in the frontend into another folder and delete frontend for the time being, 
there needs to be no frontend folder in order to create the react application using vs-code.

Make sure you've downloaded nodejs and set up react according to tutorial, once you have done that go to the root folder in the code and run.

npx create-react-app frontend

this will create the frontend folder and app with nothing in it, once this has run, check it runs by running

cd frontend
npm start

React should open and run, this is good.

After you have done this, copy our source code into the react folder. And you should be good to go.

To set up the backend, install intelliJ.
Create new SpringBoot project. And you are good to go.


