pipeline {
	agent any

	stages {
		stage('Checkout') {
			steps {
				git branch: 'master', url: 'https://github.com/MattBarhou/COMP-367-Lab2'
			}
		}

		stage('Build') {
			steps {
				sh 'mvn clean package'
			}
		}

		stage('Test') {
			steps {
				sh 'mvn test'
			}
		}

		stage('Deploy') {
			steps {
				echo 'Deploying the application...'
			}
		}
	}
}
