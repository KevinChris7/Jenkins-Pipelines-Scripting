JOB_NAME = 'git_push_notifier'
CREDENTIALS_ID = 'fe8d20e7-726f-4374-8e74-85f823fe9554'
GIT_PATH = 'git@github.com:KevinChris7/Jenkins-Pipelines-Scripting.git'
SCRIPT_PATH = 'jenkins-pipelines/git-pipeline-trigger/Jenkinsfile'
BRANCH_NAME = 'master'
GIT_REPO_NOTIFY = 'git@github.com:KevinChris7/testing-repo.git'
REPO_NOTIFY_BR = 'master'

pipelineJob(JOB_NAME){
    description('Notifies the GIT Push Events')
    logRotator{
        daysToKeep(30)
        numToKeep(10)
    }
    parameters{
        stringParam('BRANCH_NAME', BRANCH_NAME, 'Test Branch Details')
        stringParam('GIT_REPO_NOTIFY',GIT_REPO_NOTIFY, 'Test Repo')
        credentialsParam('CREDENTIALS_ID'){
            defaultValue('CREDENTIALS_ID')
        }        
    }
    definition {
        cpsScm{
            scm {
                git {                   
                    remote {
                        credentials(CREDENTIALS_ID)
                        url(GIT_PATH)
                    }
                    branch('*/master')
                }
            scriptPath(SCRIPT_PATH)
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