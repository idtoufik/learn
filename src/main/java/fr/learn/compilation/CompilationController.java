package fr.learn.compilation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompilationController {
	
	Compilation comp = new Compilation();
	
	@RequestMapping(value="/resources/compileC", method = RequestMethod.POST)
	public String compileC(@RequestBody String code){
		File temp = null;
		try {
			temp = new File("tmp/code.c");
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			bw.write(code);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		comp.compile("gcc tmp/code.c -o tmp/code");		
		return comp.run("./tmp/code");
	}
	
	/*@RequestMapping(value="/resources/compileC", method = RequestMethod.GET)
	public String compileC_(){
		String log = comp.compile("gcc ");
		System.out.println(log);
		//return log;
		return comp.run("./a.out");
	}*/
	
	@RequestMapping(value="/resources/compileCpp", method = RequestMethod.GET)
	public String compileCpp(){
		comp.compile("g++ ");
		return comp.run("./a.out");
	}
	
	@RequestMapping(value="/resources/compilePython", method = RequestMethod.GET)
	public String compilePython(){
		return comp.run("python code.py");
	}
	
	@RequestMapping(value="/resources/getCode", method = RequestMethod.GET)
	public String getCode(){
		return null;
	}

}
