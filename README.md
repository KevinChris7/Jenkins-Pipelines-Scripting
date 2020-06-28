# **Jenkins Pipeline As Code**

## **About Jenkins Pipeline**

Jenkins Pipeline is a suit of pipelines that supports implementing and integrating continuous delivery pipelines into Jenkins.
Pipeline tools are available as Pipeline as Code via the Job DSL Plugin.

**Benefits for Pipeline as Code:**
We can create multiple jobs which have similar configurations
Creating these multiple jobs by automation
We can Source Control each jobs separately

## **About Project**

1.Pipeline as Code Implementation

2.Implemented Projects

> git-pipeline-trigger

> infrastructure-build

3.Jenkinsfile is written using Scripted format

4.Groovy and Shell are used

5.PipelineJob setup is written in groovy file

## **System requirements**

Jenkins

Pipeline DSL Plugin

Job DSL Plugin

## **Infrastructure**

Amazon Linux 2 and Jenkins

## **Development Environment**

Jenkins Installed in EC2 server

Groovy and Shell

Seed job

## **Usage**

1.Write a Pipeline Job as a groovy file

2.Write a Jenkinsfile using groovy

3.Files can be maintained in Source Control Repo

4.Install the required plugins in Jenkins

5.Create a Seed Job and select DSL for adding the required Pipeline code

6.Run the Seed job manually

7.Required Pipeline jobs will be created as the result of seed job


## **Project Insider**

- **Job Type**: PipelineJob

- **Pipeline Type**: Scripted Pipeline

- **Language**: Groovy and Shell

- **Projects Implemented**:

1. Terraform Infrastructure Build Job under "infrastructure-build" sub directory

2. Git Pre-commit check Job under "git-pipeline-trigger" sub directory
