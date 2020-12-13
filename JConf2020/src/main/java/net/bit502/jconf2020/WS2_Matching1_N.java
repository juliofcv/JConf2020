/* 
 * JConf 2020
 * 12/12/2020
 *
 * Copyright 2013-2020 GIGADATTA, S.A.
 * Julio Francisco Chinchilla Valenzuela
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package net.bit502.jconf2020;

import static com.gd.utils.FileUtils.findByFileExtension;
import com.machinezoo.sourceafis.FingerprintCompatibility;
import com.machinezoo.sourceafis.FingerprintTemplate;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import net.bit502.jconf2020.sourceafis.UserDetails;

/**
 *
 * @author Julio Chinchilla
 */
public class WS2_Matching1_N {
    
    public static void main (String... args) throws IOException {
        byte templateProbe[] = com.gd.utils.ByteFilesHandler.readFile("D:\\JConf2020\\fingers\\1_N\\probe.ANSI");
        FingerprintTemplate p = FingerprintCompatibility.convert(templateProbe);
        UserDetails f = new UserDetails();
        List<UserDetails> fingers = loadFingers("D:\\JConf2020\\fingers\\1_N\\candidates");
        System.out.println(" +++++++++++++++++++++++++++++++++++++++++ ");
        System.out.println("Coincidencia con: "+f.find(p, fingers).name);
    }
    
    private static List<UserDetails> loadFingers(String dirName) throws IOException {
        List<UserDetails> users = new ArrayList();
        Path path = Paths.get(dirName);
        List<Path> paths = findByFileExtension(path, ".ANSI");
        for(Path p: paths) {
            System.out.println(p.toString());
            byte templateProbe[] = com.gd.utils.ByteFilesHandler.readFile(p.toString());
            FingerprintTemplate ft = FingerprintCompatibility.convert(templateProbe);
            UserDetails u = new UserDetails();
            u.name = "Usuario "+p.getFileName();
            u.template = ft;
            users.add(u);
        }
        return users;
    }
    
}
