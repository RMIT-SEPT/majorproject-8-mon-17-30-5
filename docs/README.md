
# All Documentation for this milestone is in the OneDrive 

link below: https://rmiteduau-my.sharepoint.com/:f:/g/personal/s3781279_student_rmit_edu_au/Ete0uNXkXq1Pl-Np2nC1214B8Av1Hq0msrDNRKcS1_YZRw?e=xnkNFM

Please access with RMIT account

Note: please also have a look inside Sprint 1 and 2 folders

# Our deployed application

* AWS S3: http://majorproject-sept.s3-website-us-east-1.amazonaws.com/

This is used for deploying frontend

Note: click on this link of S3 will be able to see the deployed project, and this is linked to deployed backend

* AWS RDS Endpoint: majorproject.cricml58bpuc.us-east-1.rds.amazonaws.com

This is using postgresql for the project tables
* AWS Elastic Beanstalk: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/

This is used for deploying backend

To use this, is the beanstalk url then follow by "/api/{usertype}/" follow by query syntax.

For example: 

To look for all workers: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/worker/

To look for all customers: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/customer/

To look for all admin: http://majorproject-env.eba-sdh23r2c.us-east-1.elasticbeanstalk.com/api/admin/

Then result as lists of workers in the current database


## To run
[Quick Start](/docs/README.md) in `docs` folder

To Start 

Clicl on this link: http://majorproject-sept.s3-website-us-east-1.amazonaws.com/ to view our application