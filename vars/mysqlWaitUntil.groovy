#!groovy
def call(String name = 'undef') {
    waitUntil {
        def r = sh (
            script: "docker exec -i ${name} grep  -w 'mysqld: ready for connections' /var/log/mysqld.log",
            returnStatus: true
        )
        echo "valor r=$r"
        if ( "$r" == '0' ){ 
            return true
        }else { 
            return false
        }
    }// end waitUntil
}//end call