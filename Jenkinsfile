pipeline {
  agent any
  stages {
    stage('Test') {
      steps {
        sh '/opt/apache-maven-3.9.10/bin/mvn test'
      }
    }
    stage('Jar') {
      steps {
        sh '/opt/apache-maven-3.9.10/bin/mvn clean package'
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
