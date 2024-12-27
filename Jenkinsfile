pipeline{
  agent any
    
  tools {
        maven 'sonarmaven'  // Name of the Maven installation in Jenkins
    }

    environment {
        SONARQUBE_SERVER = 'sonarqube'
    }
    
  stages{
    stage('Checkout'){
      steps{
        checkout scm
      }
    }
    stage('Build'){
      steps{
        bat '''
        mvn clean install
        '''
      }
    }
    stage('SonarAnalysis') {
    environment {
        SONAR_TOKEN = credentials('sonar-token') // Ensure this matches the actual credentials ID
    }
    steps {
        bat '''
        mvn clean verify sonar:sonar ^
        -Dsonar.projectKey=maven_pipeline ^
        -Dsonar.projectName=maven_pipeline ^
        -Dsonar.sources=.src/main ^
        -Dsonar.host.url=http://localhost:9000 ^
        -Dsonar.token=%SONAR_TOKEN% 
        '''
       }
    }

  }
  post{
    success{
      echo "Successfully executed"
    }
    failure {
      echo "Did not work"
    }
  }
}
