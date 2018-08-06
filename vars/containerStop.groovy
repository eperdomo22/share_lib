def call(String name = 'undef') {

try{
        def STATE = sh (
            script: "docker inspect --format='{{ .State.Status }}' ${name}",
            returnStdout: true ).trim()
            echo "STATE=$STATE"
            if ( "$STATE" == 'running' ){
                sh "echo 'EXISTE STATE=$STATE'"
                sh "echo NAME:${name}"
                sh "docker stop ${name}"
                sh "docker rm ${name}"     		
                        
            }else{ 			  			
                sh "docker rm ${name}"
	      }
    }catch (Exception err) {
    		sh "echo 'NO EXISTE'"
    		currentBuild.result = 'SUCCESS'
    }
}//end stop