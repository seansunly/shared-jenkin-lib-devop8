def call(String message) {
                
    withCredentials([usernamePassword(credentialsId: 'TOKEN_TELEGRAM',
    passwordVariable: 'TELEGRAM_TOKEN', usernameVariable: 'TELEGRAM_CHATID')]) {
      def encodedMessage = URLEncoder.encode(message, "UTF-8")
    sh """
        curl -s -X POST https://api.telegram.org/bot${TELEGRAM_TOKEN}/sendMessage \\
        -d chat_id=${TELEGRAM_CHATID} \\
        -d text="${encodedMessage}" > /dev/null
    """

           
        
        
    }     

    
}