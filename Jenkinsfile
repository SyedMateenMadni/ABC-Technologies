pipeline {
    agent any

    environment {
        IMAGE_NAME = "student-app"
        CONTAINER_NAME = "student-container"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t student-app:1.0 .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker rm -f student-container || true

                docker run -d \
                  --name student-container \
                  -p 8082:8080 \
                  student-app:1.0
                '''
            }
        }

        stage('Verify Application') {
            steps {
                sh 'curl http://localhost:8082/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline Executed Successfully'
        }

        failure {
            echo 'Pipeline Failed'
        }
    }
}
