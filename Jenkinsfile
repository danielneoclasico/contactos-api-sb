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
  }
}
