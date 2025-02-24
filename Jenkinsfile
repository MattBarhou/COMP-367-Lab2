pipeline {
    agent any

    environment {
        IMAGE_NAME = "mattbarhou/comp367-webapp"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/MattBarhou/COMP-367-Lab2.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Login') {
            steps {
               withCredentials([string(credentialsId: 'barhou', variable: 'DOCKER_PASSWORD')]) {
                   sh 'echo "$DOCKER_PASSWORD" | docker login -u mattbarhou --password-stdin'
               }
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:latest ."
            }
        }

        stage('Docker Push') {
            steps {
                sh "docker push ${IMAGE_NAME}:latest"
            }
        }

        stage('Cleanup') {
            steps {
                sh "docker rmi ${IMAGE_NAME}:latest || true"
            }
        }
    }
}
