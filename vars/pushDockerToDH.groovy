def call(String imageName){
    withCredentials([usernamePassword(credentialsId: 'DCOKERHUB', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {    
        sh """
            echo '$PASSWORD' |  docker login -u $USERNAME --password-stdin   
        docker push ${imageName}
        """
                    
    }
}