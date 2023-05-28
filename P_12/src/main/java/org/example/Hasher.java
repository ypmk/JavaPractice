package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    private String strHash ="null";
    @Autowired
    ApplicationArguments appArgs;

    @PostConstruct
    public void MakeHash() {
        var lst = appArgs.getNonOptionArgs();
        if(lst.size() < 1) return;

        var arg0 = appArgs.getNonOptionArgs().get(0);
        System.out.println("PostConstruct called: " + arg0);

        Path filePath = Path.of(arg0);
        try {
            byte[] data = Files.readAllBytes(Paths.get(filePath.toString()));
            try {
                byte[] hash = MessageDigest.getInstance("SHA-256").digest(data);
                strHash = new BigInteger(1, hash).toString(16);
                System.out.println(strHash);
            }
            catch (NoSuchAlgorithmException ex) {
                System.out.println("Failed to create Digest");
            }
        }
        catch (IOException ex) {
            System.out.println("Failed to read input file");
        }
    }

    @PreDestroy
    public void WriteHash() {
        var lst = appArgs.getNonOptionArgs();
        if(lst.size() < 2) return;
        var arg0 = appArgs.getNonOptionArgs().get(0);
        var arg1 = appArgs.getNonOptionArgs().get(1);
        System.out.println("PreDestroy called: " + arg1);

        Path filePathOut = Path.of(arg1);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOut.toString()));
            writer.write(strHash);
            writer.close();

            Path filePathIn = Path.of(arg0);
            File file = new File(filePathIn.toString());
            file.delete();
        }
        catch (IOException ex) {
            System.out.println("Failed to write to output file");
        }
    }

}
