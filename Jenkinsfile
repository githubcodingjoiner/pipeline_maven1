pipeline {
    agent any
    
    environment {
        SONARQUBE_SERVER = 'sonarqube'  // The name of the SonarQube server configured in Jenkins
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Run the Maven build with SonarQube analysis
                    sh 'mvn clean install sonar:sonar -Dsonar.projectKey=maven_pipeline -Dsonar.host.url=http://localhost:9000'
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    sonarScanner(
                        options: [
                            "-Dsonar.projectKey=maven_pipeline",
                            "-Dsonar.sources=."
                        ]
                    )
                }
            }
        }
    }

    post {
        success {
            // Clean up or post actions (e.g., publish results)
          echo "success"
        }
      failure{
        echo "did not success"
      }
    }
}
