@Library('Addressbook_Library') _
pipeline {
    agent any
    environment {
        branch = 'master'
        scmUrl = 'https://github.com/praneethss/addressbook.git'
        serverPort = '8080'
    }
    stages {
        stage('checkout git') {
            steps {
                git branch: branch, 
                    url: scmUrl
            }
        }

        stage('build') {
            steps {
                sh 'mvn clean install package'
            }
        }
    }
    post {
        changed {
            script {
                if (currentBuild.currentResult == 'FAILURE') { 
                    emailext attachLog: true, 
                    body: 'Build got Failed', 
                    subject: 'Build Messages', 
                    to: 'praneeth.srinivas1993@gmail.com'
                }
            }
        }
    }
}
