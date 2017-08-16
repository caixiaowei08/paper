package com.ring.win.cmd;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Cmd {
	public static void exec(String cmd) {
		Runtime rt = Runtime.getRuntime();
		try {
			Long startTime = System.currentTimeMillis();
			Process pro = rt.exec("nuxmv -int E:\\code\\NuSMV\\fsyncfull.smv");
			OutputStream outputStream = pro.getOutputStream();
			outputStream.write("read_model".getBytes());
			outputStream.write("flatten_hierarchy".getBytes());
			outputStream.write("build_flat_model".getBytes());
			outputStream.write("encode_variables".getBytes());
			outputStream.write("check_ltlspec_inc_coi_bdd -I".getBytes());
			outputStream.write("quit".getBytes());
			InputStream is = pro.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cmd.exec("??");
	}
	
	
}
