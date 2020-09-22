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
* Github repository : https://github.com/RMIT-SEPT/majorproject-8-mon-17-30-5/tree/milestone2-submission

This is the gitHub link for milestone2 submission
* ClickUp Workspace Sprint1: https://share.clickup.com/l/h/6k1rj-135/cfa825028cbc3ff
* ClickUp Workspace Sprint2: https://share.clickup.com/l/h/6-13306024-1/f0c937eeffefefa
* AWS RDS Endpoint: majorproject.cricml58bpuc.us-east-1.rds.amazonaws.com

This is using postgresql for the project tables
* AWS Elastic Beanstalk: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/

This is used for deploying backend

To use this, is the beanstalk url then follow by "/api/{usertype}/" follow by query syntax.

For example: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/worker/

Then result as lists of workers in the current database
* AWS S3: http://majorproject-sept.s3-website-us-east-1.amazonaws.com/

This is used for deploying frontend

## Code documentation

[Quick Start](/docs/README.md) in `docs` folder

To Start back end
open intelliJ in folder Backend
run majorprojectApplication

To Start front end
ensure to be in foler frontend
npm start

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


