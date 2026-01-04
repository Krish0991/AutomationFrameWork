pipeline {
    agent any

    tools {
        jdk 'JDK21'          // Change to your configured JDK name in Jenkins
        maven 'Maven3.9.12'       // Change to your configured Maven name
    }

    triggers {
        cron('H */12 * * *')   // Runs every 12 hours
    }

    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'develop',
                    url: 'https://github.com/Krish0991/AutomationFrameWork.git'
            }
        }

        stage('Clean & Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }

    }

    post {

        always {
            echo 'Pipeline execution completed'
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }

        success {
            echo 'Selenium tests passed successfully'
        }

        failure {
            echo 'Selenium tests failed'
        }
    }
}
