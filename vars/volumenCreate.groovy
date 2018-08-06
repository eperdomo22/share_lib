def call(String name = 'undef') {

try{
        def STATE = sh (
            script: "docker volume inspect ${name}",
            returnStatus: true )
            echo "STATE=$STATE"
            if ( "$STATE" == '1' ){
                sh "echo 'NO EXISTE VOLUMEN ${name}'"
                sh "docker volume create ${name}"
            }
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop