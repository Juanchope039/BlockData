package prueba.visual;

import BasedeDatos.Manejador_de_Base_de_Datos;
import codigo.Mensage;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Juanchope
 */
public class Interface {
    
    public static void main(String[] args) {
        pruebaenviomensages();
        //pruebarecibirmensajes();
    }

    private static void pruebaenviomensages() {
            //Manejador_de_Base_de_Datos.enviarmensage("10", "11", "12", "13");
            /*Mensage msg1 = Manejador_de_Base_de_Datos.recibirmensage("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAieokV9uraadtG0/iSGVXGgyTbqh3wWoh91JfQbxeijNUHsmgv7uxWTL017Szm8qFXT12loagsX52AVQDl7vWO0WCZtKQSe7ZHN17FpYSdKOR6LHRQC20MmcdeXzAViXJ3u7xP9dd0vtm6n5kSVvHIvNQ0RfPCkyqiLKVnB9OYOSU+Kw+f11/jE6BoWA/t7C5MRlJKvqatbS3zRnGDanteR8iMYM8XmPe8P79/2RKPkh5EGI7RENJe6fu1epTTWrzNKlA4uuZw87WUfBmh4u0JNvIGQXquWRImkURHuPDakynoQIqLrdLRgBXp9Uln+WD3Ay4WdulY17obVvicd1O6wIDAQAB");
            if (msg1 != null)
            msg1.ToString();*/
            Scanner lector = new Scanner(System.in);
            System.out.print("Escriba mensaje porfavor: ");
            String llavepublicaE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqY6TggR6buvHyOed/7ohpFyQ0t0ZfKO9NXv3Yv/wTcM7jdVAtqa/SKd8vl1kK+YjVcOO/o/eid1qrWEUDJMZ0B7Z0Bm129otzYV0q9jXz4hUEdjzFyQSQW6BSJBBla7rhVAU2M9TKuTX0jH3QIucFGwRWpX/Lga3Px7ZXqDFgUbNWWUnewELhFHQPi/7CXEL2JyVym0wophHSbzPjKi2yJTMZgC3P0VoCWfmj6cX97jrIrxn1yPZMf5NDsrkHI8YOgaunuyZ/T6mvGdoHsPuNX1q+vEBr89jgHQ5HUsfxUqziF/fjgt8M1k6ROnsT9RvvcqGiNIhvJkK6AfnqZ+4wIDAQAB",
                    llaveprivadaE = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCepjpOCBHpu68fI553/uiGkXJDS3Rl8o701e/di//BNwzuN1UC2pr9Ip3y+XWQr5iNVw47+j96J3WqtYRQMkxnQHtnQGbXb2i3NhXSr2NfPiFQR2PMXJBJBboFIkEGVruuFUBTYz1Mq5NfSMfdAi5wUbBFalf8uBrc/HtleoMWBRs1ZZSd7AQuEUdA+L/sJcQvYnJXKbTCimEdJvM+MqLbIlMxmALc/RWgJZ+aPpxf3uOsivGfXI9kx/k0OyuQcjxg6Bq6e7Jn9Pqa8Z2gew+41fWr68QGvz2OAdDkdSx/FSrOIX9+OC3wzWTpE6exP1G+9yoaI0iG8mQroB+epn7jAgMBAAECggEAQ0BJtOw806zItlV+BnXbEbg0DIy+wbyJlwXdUTfYaYoxhAWWlsgeLTHwbKAMkxGshDWkBg61u81gVsXtWaWIt7gg14r4TVifthJKO+43HJeUvZgVmPqf+yRfT2/OyqYXltrRUsfdo1OT/C848dnL37bxFuvWcn2EfarVkBXX3YwME5XWPpM1QWtGCtsnAZ+GjheeAjH8Ug5jUb2vSjzDrIoUCZVzWz8S6l+u6W1SIsih5Q4Yr5JovwiixWqlGi9huOBtXEAVlVKSAU+Pzp77QuRyVUTsGM4NT89XvPPClwvbOJITjLLU0RTfdPDTDm7956ev+bsb1SoTUGUHoN7YIQKBgQD3tUFm9Wikf6upVdqTpOB6MkU7U4Y1rKhpr4FQBRSzHlpk7eDTZ/3zfJ9kF09+339QKRzyMNP8T94Q3QZI8cieBJLM0G4wJk93F6GExlH8Q2ak5WRbIf1epjcK4vg7kCb7sav4jcvQHV6GLSUodV23UdoXyITiGQIfeNGGSuhLUQKBgQCj9cepebmMxfkbV3cZKzAX0SONyKKwoj9IXKLfcYMGa/o/hl8zpxELsj+3mUTWKJNbnlZdJpK+sR8nO2kXnc0WdNyrZLx7w+9eTdxuIB9FvI7waIsjbxcpvb0CsVBFeQ7gSrvV/wHM4DeQ+JTrLzgxXF+wkB9zNUIje8gQudSx8wKBgEhrHWvUY3t0N+ORzg1MLrSK7eKiUKJwj+wV+2BBnAOh5BuN0CT+SihdTtwcVIlrHfV5j5Te4ZrqXqnfdG7vAQ/xlll6tjwtdx4CMp52vJFbwy6CQgzCqyh4v67XHGuNgVgkYXqROfzmGTRxDmP9rCBkNbauUOspFI3O7LKuQ6uBAoGAaud3LrZSWEpA+SXXXs69Bdp0Lx8RjM/NKTZVcBFIGCjROxg2/KvCvniTePdzXZuJMSSVNRlQdwtvv5nKFP7r2OeLdikxiBUh/sAPqLJDEao3HONdTVZCqRGwqo/IQfQD0hSIUqh5mQbc1CZwmsPoBK8xKSNfjjO8kvxDXzx7RScCgYBMfO/vTVDoZTD773ukq5/or5cWT2xVdAVTDNT24pEFJ0Ze/dD0EDfssWM81sHGxD2mNLQRanbhh8X5y2cS6jOWH0/PccRhMEetKwi81celaVintaqMy23+oPoUcUEZKITxrCfBucMtVBJNoO2/zUvUvBCUkihkvYPzHlqo3Hlz6w==",
                    llavepublicaR = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAieokV9uraadtG0/iSGVXGgyTbqh3wWoh91JfQbxeijNUHsmgv7uxWTL017Szm8qFXT12loagsX52AVQDl7vWO0WCZtKQSe7ZHN17FpYSdKOR6LHRQC20MmcdeXzAViXJ3u7xP9dd0vtm6n5kSVvHIvNQ0RfPCkyqiLKVnB9OYOSU+Kw+f11/jE6BoWA/t7C5MRlJKvqatbS3zRnGDanteR8iMYM8XmPe8P79/2RKPkh5EGI7RENJe6fu1epTTWrzNKlA4uuZw87WUfBmh4u0JNvIGQXquWRImkURHuPDakynoQIqLrdLRgBXp9Uln+WD3Ay4WdulY17obVvicd1O6wIDAQAB" ;
            Mensage msg2 = new Mensage(llavepublicaE, llaveprivadaE, llavepublicaE, /*"#"*/lector.nextLine());
            msg2.prueba();/*
            System.out.println(msg2.gethashMensage());
            System.out.println(msg2.getFirmaDigitalDecifrada());
            System.out.println((msg2.gethashMensage()).equals(msg2.getFirmaDigitalDecifrada()));
            if ((msg2.gethashMensage()).equals(msg2.getFirmaDigitalDecifrada()))
                Manejador_de_Base_de_Datos.enviarmensage(msg2);
            Mensage msg3 = new Mensage();
            msg3.setLlavePublicaEmisor(msg2.getLlavePublica());
            System.out.println("1" + msg2.getLlavePublica().equals(msg3.getLlavePublica()));
            msg3.setLlavepublicaReceptor(msg2.getLlavepublicaReceptor());
            System.out.println("2" + msg2.getLlavepublicaReceptor().equals(msg3.getLlavepublicaReceptor())); 
            msg3.setFirmaDigital(msg2.getFirmaDigital());
            System.out.println("3" + msg2.getFirmaDigital().equals(msg3.getFirmaDigital()));
            msg3.setMensageCifrado(msg2.CifrarMensage());
            System.out.println("vdjavc-" + msg2.CifrarMensage());
            System.out.println("hacjcv-" + msg3.CifrarMensage());
            System.out.println("4" + msg2.CifrarMensage().equals(msg3.CifrarMensage()));
            if ((msg3.gethashMensage()).equals(msg3.getFirmaDigitalDecifrada()))
                System.out.println("prueba correcta");
            
            System.out.println("1-" + msg2.getFirmaDigitalDecifrada());
            System.out.println("2-" + msg3.gethashMensage());
            System.out.println("3-" + msg2.hashSHA(msg3.getMensage()));
            //System.out.println(msg3.gethashMensage());
            //System.out.println(msg3.getFirmaDigitalDecifrada());*/
    }

    private static void pruebarecibirmensajes() {
        String llavepublicaE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqY6TggR6buvHyOed/7ohpFyQ0t0ZfKO9NXv3Yv/wTcM7jdVAtqa/SKd8vl1kK+YjVcOO/o/eid1qrWEUDJMZ0B7Z0Bm129otzYV0q9jXz4hUEdjzFyQSQW6BSJBBla7rhVAU2M9TKuTX0jH3QIucFGwRWpX/Lga3Px7ZXqDFgUbNWWUnewELhFHQPi/7CXEL2JyVym0wophHSbzPjKi2yJTMZgC3P0VoCWfmj6cX97jrIrxn1yPZMf5NDsrkHI8YOgaunuyZ/T6mvGdoHsPuNX1q+vEBr89jgHQ5HUsfxUqziF/fjgt8M1k6ROnsT9RvvcqGiNIhvJkK6AfnqZ+4wIDAQAB";
        ArrayList<Mensage> msgs = Manejador_de_Base_de_Datos.recibirmensage(llavepublicaE);//"hola diana"
        ArrayList<String> Destinatarios = new ArrayList<>();
        int con=0;
        for (Mensage msg :msgs){
            con++;
            System.out.print(con + "-");
//            if (!(llavepublicaE).equals(msg.getLlavepublicaReceptor())){
//                System.out.println("-Denegado.");
//                continue;
//            }if (!msg.ComprobarMensage()){
//                System.out.println("-Denegado.");
//                continue;
//            }System.out.println("-Aceptado.");
//            msg.CargarLlaves("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqY6TggR6buvHyOed/7ohpFyQ0t0ZfKO9NXv3Yv/wTcM7jdVAtqa/SKd8vl1kK+YjVcOO/o/eid1qrWEUDJMZ0B7Z0Bm129otzYV0q9jXz4hUEdjzFyQSQW6BSJBBla7rhVAU2M9TKuTX0jH3QIucFGwRWpX/Lga3Px7ZXqDFgUbNWWUnewELhFHQPi/7CXEL2JyVym0wophHSbzPjKi2yJTMZgC3P0VoCWfmj6cX97jrIrxn1yPZMf5NDsrkHI8YOgaunuyZ/T6mvGdoHsPuNX1q+vEBr89jgHQ5HUsfxUqziF/fjgt8M1k6ROnsT9RvvcqGiNIhvJkK6AfnqZ+4wIDAQAB", 
//                             "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCepjpOCBHpu68fI553/uiGkXJDS3Rl8o701e/di//BNwzuN1UC2pr9Ip3y+XWQr5iNVw47+j96J3WqtYRQMkxnQHtnQGbXb2i3NhXSr2NfPiFQR2PMXJBJBboFIkEGVruuFUBTYz1Mq5NfSMfdAi5wUbBFalf8uBrc/HtleoMWBRs1ZZSd7AQuEUdA+L/sJcQvYnJXKbTCimEdJvM+MqLbIlMxmALc/RWgJZ+aPpxf3uOsivGfXI9kx/k0OyuQcjxg6Bq6e7Jn9Pqa8Z2gew+41fWr68QGvz2OAdDkdSx/FSrOIX9+OC3wzWTpE6exP1G+9yoaI0iG8mQroB+epn7jAgMBAAECggEAQ0BJtOw806zItlV+BnXbEbg0DIy+wbyJlwXdUTfYaYoxhAWWlsgeLTHwbKAMkxGshDWkBg61u81gVsXtWaWIt7gg14r4TVifthJKO+43HJeUvZgVmPqf+yRfT2/OyqYXltrRUsfdo1OT/C848dnL37bxFuvWcn2EfarVkBXX3YwME5XWPpM1QWtGCtsnAZ+GjheeAjH8Ug5jUb2vSjzDrIoUCZVzWz8S6l+u6W1SIsih5Q4Yr5JovwiixWqlGi9huOBtXEAVlVKSAU+Pzp77QuRyVUTsGM4NT89XvPPClwvbOJITjLLU0RTfdPDTDm7956ev+bsb1SoTUGUHoN7YIQKBgQD3tUFm9Wikf6upVdqTpOB6MkU7U4Y1rKhpr4FQBRSzHlpk7eDTZ/3zfJ9kF09+339QKRzyMNP8T94Q3QZI8cieBJLM0G4wJk93F6GExlH8Q2ak5WRbIf1epjcK4vg7kCb7sav4jcvQHV6GLSUodV23UdoXyITiGQIfeNGGSuhLUQKBgQCj9cepebmMxfkbV3cZKzAX0SONyKKwoj9IXKLfcYMGa/o/hl8zpxELsj+3mUTWKJNbnlZdJpK+sR8nO2kXnc0WdNyrZLx7w+9eTdxuIB9FvI7waIsjbxcpvb0CsVBFeQ7gSrvV/wHM4DeQ+JTrLzgxXF+wkB9zNUIje8gQudSx8wKBgEhrHWvUY3t0N+ORzg1MLrSK7eKiUKJwj+wV+2BBnAOh5BuN0CT+SihdTtwcVIlrHfV5j5Te4ZrqXqnfdG7vAQ/xlll6tjwtdx4CMp52vJFbwy6CQgzCqyh4v67XHGuNgVgkYXqROfzmGTRxDmP9rCBkNbauUOspFI3O7LKuQ6uBAoGAaud3LrZSWEpA+SXXXs69Bdp0Lx8RjM/NKTZVcBFIGCjROxg2/KvCvniTePdzXZuJMSSVNRlQdwtvv5nKFP7r2OeLdikxiBUh/sAPqLJDEao3HONdTVZCqRGwqo/IQfQD0hSIUqh5mQbc1CZwmsPoBK8xKSNfjjO8kvxDXzx7RScCgYBMfO/vTVDoZTD773ukq5/or5cWT2xVdAVTDNT24pEFJ0Ze/dD0EDfssWM81sHGxD2mNLQRanbhh8X5y2cS6jOWH0/PccRhMEetKwi81celaVintaqMy23+oPoUcUEZKITxrCfBucMtVBJNoO2/zUvUvBCUkihkvYPzHlqo3Hlz6w==");
//            System.out.println(msg.DecifrarMensage());
//            Destinatarios.add(msg.DecifrarMensage());//*/
        }/*
        System.out.println("1-" + msgs.get(0).getLlavePublica());
        System.out.println("2-" + msgs.get(0).getLlavePrivada());
        System.out.println("3-" + msgs.get(0).getLlavepublicaReceptor());
        System.out.println("4-" + msgs.get(0).getMensage());
        System.out.println("5-" + msgs.get(0).CifrarMensage());
        System.out.println("6-" + msgs.get(0).getFirmaDigital());
        System.out.println("7-" + msgs.get(0).gethashMensage());
        try {
            System.out.println("123-" +msgs.get(0).hashSHA("hola diana"));
        } catch (Exception ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("8-" + msgs.get(0).getFirmaDigitalDecifrada());
        System.out.println("9-" + msgs.get(0).getFirmaDigitalDecifrada().equals(msgs.get(0).gethashMensage()));//*/
        System.out.println("                *** mensages. ***");
        for (String Destinatario : Destinatarios){
            System.out.println(Destinatario);
            
        }
    }
    
}
