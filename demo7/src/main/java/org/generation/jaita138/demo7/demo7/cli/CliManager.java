package org.generation.jaita138.demo7.demo7.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo7.demo7.db.entity.Negozio;
import org.generation.jaita138.demo7.demo7.db.service.NegozioService;

public class CliManager {

    Scanner input;
    private NegozioService negozioService;

    public CliManager(NegozioService negozioService){
        input= new Scanner(System.in);
        this.negozioService=negozioService;

        MostraOpzioni();

    }

    private void MostraOpzioni(){

        System.out.println("Operazioni:");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5. Mostra Utenti che iniziano con una Lettera");
        System.out.println("6. Mostra Utenti che hanno credito maggiore di..");
        System.out.println("7. Mostra Utenti che hanno nome null e cognome null");
        System.out.println("8. Mostra Utente che hanno un credito in un range");
        System.out.println("9. Esci");
        System.out.println("");

        String strValue = input.nextLine();
        int valore = Integer.parseInt(strValue);

        switch(valore){

            case 1:
            Leggi();
            break;
            case 2:
            inserisci();
            break;
            case 3:
            Modifica();
            break;
            case 4:
            elimina();
            break;
            case 5:
            CercaPerLetteraIniziale();
            break;
            case 6:
            trovaPerCreditoMaggiore();
            break;
            case 7:
            CercaINull();
            break;
            case 8:
            CercaInRange();
            break;
            case 9:
            return;

            default:
            System.out.println("Errore di digitalizzazione.");
            break;
        }

        MostraOpzioni();

    }

    private void Leggi(){

        List<Negozio> negozio=negozioService.findAll();
        System.out.println("Ecco i prodotti:");
        System.out.println(negozio);
    }

    private void inserisci(){

        Negozio n=new Negozio();

        System.out.println("Inserisci il nome:");
        String nome=input.nextLine();
        n.setNome(nome);

        System.out.println("Inserisci il cognome: ");
        String cognome=input.nextLine();
        n.setCognome(cognome);

        System.out.println("Inserisci Username: ");
        String utente=input.nextLine();
        n.setUsername(utente);

        System.out.println("Inserisci la Password: ");
        String psw=input.nextLine();
        n.setPsw(psw);

        System.out.println("Inserisci il credito in centesimi: ");
        int credito=input.nextInt();
        input.nextLine();
        n.setCredito(credito);

        negozioService.save(n);
    }

    private void Modifica(){
        System.out.println("Modifica riga. (Scrivi ID)");
        String id_stringa=input.nextLine();
        Long id=Long.parseLong(id_stringa);
        Negozio n=negozioService.findById(id);

        if (n!=null){
            System.out.println("Inserisci nuovo nome:");
            String nome= input.nextLine();
            n.setNome(nome);

            System.out.println("Scrivi il nuovo cognome:");
            String cognome=input.nextLine();
            n.setCognome(cognome);

            System.out.println("Scrivi il nuovo username: ");
            String username=input.nextLine();
            n.setUsername(username);

            System.out.println("Scrivi la nuova psw: ");
            String psw=input.nextLine();
            n.setPsw(psw);

            System.out.println("Scrivi il nuovo credito: (In centesimi)");
            String credito_str=input.nextLine();
            int credito=Integer.parseInt(credito_str);
            n.setCredito(credito);

            negozioService.save(n);

        }else {
            System.out.println("Utente non trovato");
        }
        
    }

    private void elimina(){
        System.out.println("Elimina per id: ");
        String id_stringa=input.nextLine();
        Long id=Long.parseLong(id_stringa);
        Negozio n =negozioService.findById(id);

        if (n!=null){
            negozioService.delete(n);
            System.out.println("L'Utente"+id+" è stato eliminato");
        }else {
            System.out.println("Utente non trovato");
        }


    }

    private void trovaPerCreditoMaggiore(){
        System.out.println("Inserisci il credito: ");
        String credito_str=input.nextLine();
        int credito=Integer.parseInt(credito_str);
        int credito_effettivo=credito*100;

        List<Negozio> negozio=negozioService.CreditoMaggioreA(credito_effettivo);
        System.out.println("Gli utenti sono: ");
        System.out.println(negozio);
    }

    private void CercaPerLetteraIniziale(){
        System.out.println("Inserisci la lettera: ");
        String carattere=input.nextLine();

        List<Negozio> utenti=negozioService.TrovaPerLettera(carattere);
        System.out.println("Gli utenti sono: ");
        System.out.println(utenti);
    }

    private void CercaINull(){
        List<Negozio> utenti=negozioService.NomeNullCognomeNull();
        System.out.println("Gli Utenti nulli sono: ");
        System.out.println(utenti);
    }

    private void CercaInRange(){
        System.out.println("Scrivi il valore  minimo: ");
        String credito_minstr=input.nextLine();
        int credito_min=Integer.parseInt(credito_minstr)*100;
        System.out.println("Scrivi il valore massimo: ");
        String credito_maxstr=input.nextLine();
        int credito_max=Integer.parseInt(credito_maxstr)*100;


        List<Negozio> utenti=negozioService.Utenti0e10(credito_min,credito_max);
        System.out.println("Gli utenti sono: ");
        System.out.println(utenti);

    }
}
