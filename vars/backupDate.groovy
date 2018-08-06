#!groovy
import java.text.SimpleDateFormat
import java.util.*;

def call(String format = 'undef' ) {
	if ( "$format" == 'short'  ){
		def date = new Date()
		sdf = new SimpleDateFormat("yyyy-MM-dd")
		return sdf.format(date) as String
	}else {
		println('FORMAT ERROR ')
	}//end ifelse
}
