pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('barhou') // Using stored credentials
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
                script {
                    sh """
                        echo '${DOCKER_HUB_CREDENTIALS_PSW}' | docker login -u '${DOCKER_HUB_CREDENTIALS_USR}' --password-stdin
                    """
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
                sh "docker rmi ${IMAGE_NAME}:latest"
            }
        }
    }
}
