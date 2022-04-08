def call(name){
pipeline {
    agent any
    
    stages {
        stage('Git Checkout') {
            steps {
                git 'https://github.com/praneethss/addressbook.git'
            }
        }
        
        stage('Maven Build') {
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
                    body: 'Build got succeed', 
                    subject: 'Build Messages', 
                    to: 'praneeth.srinivas1993@gmail.com'
                }
            }
        }
    }
}
}
