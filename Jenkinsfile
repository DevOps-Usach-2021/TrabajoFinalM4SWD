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


        // stage('Test Newman') {
        //     steps {
        //         sh "newman run mindicador.cl.postman_collection.json -n 3"
        //     }
        // }
    }
}
