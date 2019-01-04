<?php
	/*funcion que transforma cadena en json*/
	function mostrar_json($texto){
		$valores=explode("-",$texto);
		foreach($valores as $fila){
			$valores1=explode("$",$fila);
			$res[]=array("variable"=>$valores1[0],"valor"=>$valores1[1]);
		}
		return json_encode($res);
	}
	
	/*intentando realizar una conexion*/
	$direccion='127.0.0.1';
	$puerto='8888';
	/*creo el socket*/
	$socket=socket_create(AF_INET,SOCK_STREAM,SOL_TCP);
	if($socket==false){
		echo "fallo la creacion conexion";
	}
	$result=socket_connect($socket,$direccion,$puerto);
	if($result==false){
		echo "fallo la conexion";
	}
	$modo=$_GET["modo"];
	if($modo=='a' || $modo=='m' || $modo=='b'){
		if($modo=='a'){
			$variable=$_GET["variable"];
			if($variable!=""){
				$in=$modo.'-'.$variable."\n";
			}else{
				$in="\n";
			}
		}	
		if($modo=='m'){
			$in="m\n";
		}
		if($modo=='b'){
			$variable=$_GET["variable"];
                        if($variable!=""){
                                $in=$modo.'-'.$variable."\n";
                        }else{
                                $in="\n";
                        }
		}		
	}else{
		$in="\n";
	}
	$out='';
	socket_write($socket,$in,strlen($in));
	while($out=socket_read($socket,2048)){
		echo mostrar_json($out);
	}

		
	socket_close($socket);	
	
?>
