BUILD_INFRASTRUCTURE = 'cjk_terraform'
PROJECT_NAME = 'cjk'
CJK_GIT_URL = 'git@github.com:KevinChris7/Terraform-AWS-2Tier-WebApplication.git'
BRANCH_NAME = 'master'
TERRAFORM_VERSION = '0.12.26'
REGION = 'ap-south-1'
BUCKET_NAME = 'terraform-state-7777'
CREDENTIALS_ID = 'fe8d20e7-726f-4374-8e74-85f823fe9554'
OPERATION = 'OPERATION'
CHANNEL_NAME = '#devops'

pipelineJob(BUILD_INFRASTRUCTURE){
    displayName(PROJECT_NAME)
    description('Deploys the Terraform configurations for AWS 2 Tier WebApp')
    logRotator{
        daysToKeep(30)
        numToKeep(10)
    }
    parameters{
        stringParam('BRANCH_NAME', BRANCH_NAME, 'CJK Branch Details')
        stringParam('TERRAFORM_VERSION', TERRAFORM_VERSION, 'Version of Terraform to Deploy')
        stringParam('CJK_GIT_URL', CJK_GIT_URL, 'Terraform Project Infrastructure')
        choiceParam('OPERATION', ['apply', 'destroy'])
        stringParam('REGION', defaultValue = REGION)
        stringParam('BUCKET_NAME', BUCKET_NAME)
        credentialsParam('CREDENTIALS_ID'){
            defaultValue('CREDENTIALS_ID')
        }
    }
    definition{
        cpsScm{
            scm{
                git{
                    remote {
                        credentials(CREDENTIALS_ID)
                        url("git@github.com:KevinChris7/Jenkins-Pipelines-Scripting.git")
                    }
                    branch('*/master')
                }
            scriptPath('jenkins-pipelines/infrastructure-build/Jenkinsfile')
            lightweight()
            }
        }
    }
    properties{
        rebuild{
            autoRebuild(false)
            rebuildDisabled(false)
        }
    }

}