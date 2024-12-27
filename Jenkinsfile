pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'sonarqube'  // The name of the SonarQube server configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    bat """
                        mvn clean verify sonar:sonar ^
                        -Dsonar.projectKey=maven_pipeline ^
                        -Dsonar.projectName=maven_pipeline ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.token=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Build and analysis successful"
        }
        failure {
            echo "Build or analysis failed"
        }
    }
}
