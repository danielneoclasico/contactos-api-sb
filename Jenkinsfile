pipeline {
  agent { label 'linux' }
  stages {
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Jar') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Build') {
      steps {
        sh 'docker build -t danieltl/contactos-api-sb:latest .'
      }
    }
    stage('Push a Docker Hub') {
      steps {
        sh 'docker push danieltl/contactos-api-sb:latest'
      }
    }
    stage('Crea Azure Container') {
      steps {
        sh 'az containerapp up --name contactos-api-sb --image danieltl/contactos-api-sb:latest --resource-group contenedores --environment managedEnvironment-contenedores-a4f5 --ingress external --target-port 8080'
      }
    }
  }
}
