docker call(String ProjectName, String ImageTag, String DockerHubUser){
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
        sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
    }
    sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}