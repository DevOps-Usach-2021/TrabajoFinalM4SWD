pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh "mvn clean"
            }
        }

        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('Build Artifact') {
            steps {
                sh "echo 'Build .Jar!'"
                // Run Maven on a Unix agent.
                sh 'mvn clean package -e'
            }
        }

        stage('Run Jar') {
            steps {
                sh 'nohup java -jar target/devops-0.0.1-SNAPSHOT.jar & >/dev/null'
                // Run Maven on a Unix agent.
                sh 'sleep 10'
                sh 'curl -X GET "http://localhost:8081"'
            }
        }

        stage('Test Newman') {
            steps {
                sh 'newman run src/test/Laboratorio4Grupo1PostmanCollection.postman_collection.json'
            }
        }

        stage('Clone selenium tests') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/DevOps-Usach-2021/TrabajoFinalM4Selenium'

                sh "ls -lat"
            }
        }

        stage('Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
