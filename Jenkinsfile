pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "flamecff/shoppingcart:1.0"
        DOCKER_REGISTRY = "docker.io"
        DOCKER_CREDENTIALS_ID = "Docker_Hub"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/RedEyeSH/Otp2.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: "$DOCKER_CREDENTIALS_ID",
                                                  passwordVariable: 'DOCKER_PASSWORD',
                                                  usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                    sh "docker push $DOCKER_IMAGE"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
