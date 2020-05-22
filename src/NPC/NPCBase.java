package NPC;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import Corpus.CorpusLoader;

public class NPCBase {
	
	public String name;
	public Date birth;
	public Date expired;
	public String id;
	public String country;
	public String city;
	public boolean foreigner = false;
	public int wrongType;
	public boolean friendly = true;
	public boolean plead = false;
	
	public NPCBase(String n, String co, String ci, boolean f, int w){
		this.name=n;
		this.country = co;
		this.city = ci;
		this.birth = randomDate("1900-01-01", "1973-01-01");
		this.expired = randomDate("1984-01-01","1993-12-31");
		this.id = getUUID();
		this.foreigner = f;
		this.wrongType = w;
	}
	
	
	public void generatePassport() {
		String border = "---------------------------------------";
		
		String nameLine = "| "+name;
		nameLine = String.format("%1$-37s", nameLine)+" |";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		
		String birthStr = format.format(birth);
		String birthLine = "| date of birth: "+birthStr;
		birthLine = String.format("%1$-37s", birthLine)+" |";
		
		
		String cityLine = "| region: "+city;
		cityLine = String.format("%1$-37s", cityLine)+" |";
		
		String expiredStr = format.format(expired);
		String expiredLine = "| expiration date: "+expiredStr;
		expiredLine = String.format("%1$-37s", expiredLine)+" |";
		
		String countryLine = "| "+country;
		countryLine = String.format("%1$-37s", countryLine)+" |";
		
		String idLine = "| "+id;
		idLine = String.format("%1$-37s", idLine)+" |";
		
		System.out.println(border);
		System.out.println(nameLine);
		System.out.println(birthLine);
		System.out.println(cityLine);
		System.out.println(expiredLine);
		System.out.println(countryLine);
		System.out.println(idLine);
		System.out.println(border);
	}
	
	public void generateAttache() {
		if(foreigner == true) {
			switch(wrongType) {
			case -1:
				String border = "-----------------------------";
				
				String nameLine = "| "+name;
				nameLine = String.format("%1$-35s", nameLine)+" |";
				
				String addLine = "| "+city;
				String cl = String.valueOf(35-country.length());
				String fm = "%1$-"+cl+"s";
				addLine = String.format(fm, addLine)+country+" |";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				String birthStr = format.format(birth);
				String birthLine = "| date of birth: "+birthStr;
				birthLine = String.format("%1$-35s", birthLine)+" |";
				
				
				String desLine = "|       Valid Passport Number       |";
				
				String idLine = "| "+id;
				idLine = String.format("%1$-35s", idLine)+" |";
				
				String exLine = "|          Valid VISA Until         |";
				
				String expiredStr = format.format(randomDate("1983-12-01","1984-01-31"));
				String expiredLine = "| expiration date: "+expiredStr;
				expiredLine = String.format("%1$-35s", expiredLine)+" |";
				
				System.out.println(border);
				System.out.println(addLine);
				System.out.println(nameLine);
				System.out.println(birthLine);
				System.out.println(desLine);
				System.out.println(idLine);
				System.out.println(exLine);
				System.out.println(expiredLine);
				System.out.println(border);
				break;
			case 0:
				break;
			case 1:
				String border1 = "-----------------------------";
				
				String nameLine1 = "| "+name;
				nameLine1 = String.format("%1$-35s", nameLine1)+" |";
				
				String addLine1 = "| "+city;
				String cl1 = String.valueOf(35-country.length());
				String fm1 = "%1$-"+cl1+"s";
				addLine1 = String.format(fm1, addLine1)+country+" |";
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				
				String birthStr1 = format1.format(birth);
				String birthLine1 = "| date of birth: "+birthStr1;
				birthLine1 = String.format("%1$-35s", birthLine1)+" |";
				
				
				String desLine1 = "|       Valid Passport Number       |";
				
				String idLine1 = "| "+id;
				idLine1 = String.format("%1$-35s", idLine1)+" |";
				
				String exLine1 = "|          Valid VISA Until         |";
				
				String expiredStr1 = format1.format(randomDate("1983-10-01","1983-10-31"));
				String expiredLine1 = "| expiration date: "+expiredStr1;
				expiredLine1 = String.format("%1$-35s", expiredLine1)+" |";
				
				System.out.println(border1);
				System.out.println(addLine1);
				System.out.println(nameLine1);
				System.out.println(birthLine1);
				System.out.println(desLine1);
				System.out.println(idLine1);
				System.out.println(exLine1);
				System.out.println(expiredLine1);
				System.out.println(border1);
				break;
			case 2:
				String border11 = "-----------------------------";
				
				String nameLine11 = "| "+name;
				nameLine11 = String.format("%1$-35s", nameLine11)+" |";
				
				String addLine11 = "| "+city;
				String cl11 = String.valueOf(35-country.length());
				String fm11 = "%1$-"+cl11+"s";
				addLine11 = String.format(fm11, addLine11)+country+" |";
				
				SimpleDateFormat format11 = new SimpleDateFormat("yyyy-MM-dd");
				
				String birthStr11 = format11.format(birth);
				String birthLine11 = "| date of birth: "+birthStr11;
				birthLine11 = String.format("%1$-35s", birthLine11)+" |";
				
				
				String desLine11 = "|       Valid Passport Number       |";
				
				String wrongId = getUUID();
				String idLine11 = "| "+wrongId;
				idLine11 = String.format("%1$-35s", idLine11)+" |";
				
				String exLine11 = "|          Valid VISA Until         |";
				
				String expiredStr11 = format11.format(randomDate("1983-12-01","1984-01-31"));
				String expiredLine11 = "| expiration date: "+expiredStr11;
				expiredLine11 = String.format("%1$-35s", expiredLine11)+" |";
				
				System.out.println(border11);
				System.out.println(addLine11);
				System.out.println(nameLine11);
				System.out.println(birthLine11);
				System.out.println(desLine11);
				System.out.println(idLine11);
				System.out.println(exLine11);
				System.out.println(expiredLine11);
				System.out.println(border11);
				break;
			case 3:
				String border111 = "-----------------------------";
				
				String nameLine111 = "| "+name;
				nameLine111 = String.format("%1$-35s", nameLine111)+" |";
				
				List<String> sl = new ArrayList<String>();
				for(String co:NPCGenerator.countryList) {
					if(!co.contentEquals(country)) {
						sl.add(co);
					}
				}
				Random rand = new Random();
				String wrongCoun = sl.get(rand.nextInt(sl.size()));
				String wrongCity = NPCGenerator.countryMap.get(wrongCoun).get(rand.nextInt(3));
				String addLine111 = "| "+wrongCity;
				String cl111 = String.valueOf(35-country.length());
				String fm111 = "%1$-"+cl111+"s";
				addLine111 = String.format(fm111, addLine111)+country+" |";
				
				SimpleDateFormat format111 = new SimpleDateFormat("yyyy-MM-dd");
				
				String birthStr111 = format111.format(birth);
				String birthLine111 = "| date of birth: "+birthStr111;
				birthLine111 = String.format("%1$-35s", birthLine111)+" |";
				
				
				String desLine111 = "|       Valid Passport Number       |";
				
				String idLine111 = "| "+id;
				idLine111 = String.format("%1$-35s", idLine111)+" |";
				
				String exLine111 = "|          Valid VISA Until         |";
				
				String expiredStr111 = format111.format(randomDate("1983-12-01","1984-01-31"));
				String expiredLine111 = "| expiration date: "+expiredStr111;
				expiredLine111 = String.format("%1$-35s", expiredLine111)+" |";
				
				System.out.println(border111);
				System.out.println(addLine111);
				System.out.println(nameLine111);
				System.out.println(birthLine111);
				System.out.println(desLine111);
				System.out.println(idLine111);
				System.out.println(exLine111);
				System.out.println(expiredLine111);
				System.out.println(border111);
			}		
		}
	}
	
	public void talkBeforeCheck(int f, int s) throws Exception {
		Random rand = new Random();
		Thread.sleep(1500);
		if(this.wrongType==-1) {
			int rng = rand.nextInt(100);
			if(rng<f) {
				System.out.println(this.name+": "+CorpusLoader.before_check_both.get(rand.nextInt(CorpusLoader.before_check_both.size())));
				//friendly = true; plead = false;
			}else {
				System.out.println(this.name+": "+CorpusLoader.before_check_pass.get(rand.nextInt(CorpusLoader.before_check_pass.size())));
				this.friendly = false;
				//friendly = false; plead = false;
			}
		}else {
			int rng = rand.nextInt(100);
			if(rng<s) {
				int rng_ = rand.nextInt(100);
				if(rng_<f) {
					System.out.println(this.name+": "+CorpusLoader.before_check_both.get(rand.nextInt(CorpusLoader.before_check_both.size())));
					//friendly = true; plead = false;
				}else {
					System.out.println(this.name+": "+CorpusLoader.before_check_pass.get(rand.nextInt(CorpusLoader.before_check_pass.size())));
					this.friendly = false;
					//friendly = false; plead = false;
				}
			}else {
				System.out.println(this.name+": "+CorpusLoader.before_check_refuse.get(rand.nextInt(CorpusLoader.before_check_refuse.size())));
				this.plead = true;
				//friendly = true; plead = true;
			}
		}
		Thread.sleep(1500);
		System.out.println(this.name+": Here you are.");
		Thread.sleep(1500);
	}
	
	public void talkAfterCheck(String playerName) throws Exception{
		Random rand = new Random();
		Thread.sleep(1500);
		if(this.plead == false) {
			switch(wrongType) {
			case -1:
				System.out.println(playerName+": Your VISA is invalid, can you explain it?");
				Thread.sleep(1500);
				System.out.println(this.name+": "+CorpusLoader.after_check_nor.get(rand.nextInt(CorpusLoader.after_check_nor.size())));
				Thread.sleep(1500);
				break;
			case 0:
				System.out.println(playerName+": Where is your VISA?");
				Thread.sleep(1500);
				if(rand.nextInt(100)<80) {
					System.out.println(this.name+": "+CorpusLoader.after_check_nor.get(rand.nextInt(CorpusLoader.after_check_nor.size())));
				}else {
					System.out.println(this.name+": "+CorpusLoader.after_check_exp_n.get(rand.nextInt(CorpusLoader.after_check_exp_n.size())));
				}
				Thread.sleep(1500);
				break;
			case 1:
				System.out.println(playerName+": Your VISA is invalid, can you explain it?");
				Thread.sleep(1500);
				if(rand.nextInt(100)<80) {
					System.out.println(this.name+": "+CorpusLoader.after_check_nor.get(rand.nextInt(CorpusLoader.after_check_nor.size())));
				}else {
					System.out.println(this.name+": "+CorpusLoader.after_check_exp_e.get(rand.nextInt(CorpusLoader.after_check_exp_e.size())));
				}
				Thread.sleep(1500);
				break;
			case 2:
				System.out.println(playerName+": Your VISA is invalid, can you explain it?");
				Thread.sleep(1500);
				if(rand.nextInt(100)<80) {
					System.out.println(this.name+": "+CorpusLoader.after_check_nor.get(rand.nextInt(CorpusLoader.after_check_nor.size())));
				}else {
					System.out.println(this.name+": "+CorpusLoader.after_check_exp_i.get(rand.nextInt(CorpusLoader.after_check_exp_i.size())));
				}
				Thread.sleep(1500);
				break;
			case 3:
				System.out.println(playerName+": Your VISA is invalid, can you explain it?");
				Thread.sleep(1500);
				if(rand.nextInt(100)<80) {
					System.out.println(this.name+": "+CorpusLoader.after_check_nor.get(rand.nextInt(CorpusLoader.after_check_nor.size())));
				}else {
					System.out.println(this.name+": "+CorpusLoader.after_check_exp_c.get(rand.nextInt(CorpusLoader.after_check_exp_c.size())));
				}
				Thread.sleep(1500);
				break;
			}
		}else {
			System.out.println(playerName+": Your VISA is invalid, can you explain it?");
			Thread.sleep(1500);
			if(rand.nextInt(100)<50) {
				System.out.println(this.name+": "+CorpusLoader.after_check_ple_g.get(rand.nextInt(CorpusLoader.after_check_ple_g.size())));
			}else {
				switch(this.country) {
				case "Antegria":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_ant.get(rand.nextInt(CorpusLoader.after_check_ple_ant.size())));
					break;
				case "Impor":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_imp.get(rand.nextInt(CorpusLoader.after_check_ple_imp.size())));
					break;
				case "Kolechia":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_kol.get(rand.nextInt(CorpusLoader.after_check_ple_kol.size())));
					break;
				case "Republia":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_rep.get(rand.nextInt(CorpusLoader.after_check_ple_rep.size())));
					break;
				case "United Federation":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_uni.get(rand.nextInt(CorpusLoader.after_check_ple_uni.size())));
					break;
				case "Arstotzka":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_g.get(rand.nextInt(CorpusLoader.after_check_ple_g.size())));
					break;
				case "Obristan":
					System.out.println(this.name+": "+CorpusLoader.after_check_ple_g.get(rand.nextInt(CorpusLoader.after_check_ple_g.size())));
					break;
				}
			}
			Thread.sleep(1500);
		}
	}
	
	public void talkFinal(boolean pass) throws Exception {
		Random rand = new Random();
		Thread.sleep(1500);
		if(pass == true) {
			if(this.wrongType == -1) {
				if(this.friendly == true && this.plead == false) {
					System.out.println(this.name+": "+CorpusLoader.final_pass_val_f.get(rand.nextInt(CorpusLoader.final_pass_val_f.size())));
				}else if(this.friendly == false && this.plead == false) {
					System.out.println(this.name+": "+CorpusLoader.final_pass_val_r.get(rand.nextInt(CorpusLoader.final_pass_val_r.size())));
				}
			}else {
				if(this.friendly == true && this.plead == false) {
					System.out.println(this.name+": "+CorpusLoader.final_pass_inval_f.get(rand.nextInt(CorpusLoader.final_pass_inval_f.size())));
				}else if(this.friendly == false && this.plead == false) {
					System.out.println(this.name+": "+CorpusLoader.final_pass_inval_r.get(rand.nextInt(CorpusLoader.final_pass_inval_r.size())));
				}else if(this.friendly == true && this.plead == true) {
					System.out.println(this.name+": "+CorpusLoader.final_pass_inval_f.get(rand.nextInt(CorpusLoader.final_pass_inval_f.size())));
				}
			}
		}else {
			System.out.println(this.name+": "+CorpusLoader.final_refuse.get(rand.nextInt(CorpusLoader.final_refuse.size())));
		}
		Thread.sleep(1500);
	}
	
	
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
	
	public static Date randomDate(String beginDate,String  endDate ){
		 
        try {
 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 
            Date start = format.parse(beginDate);//构造开始日期
 
            Date end = format.parse(endDate);//构造结束日期
 
            //getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
 
            if(start.getTime() >= end.getTime()){
 
                return null;
 
            }
 
            long date = random(start.getTime(),end.getTime());
 
            return new Date(date);
 
        } catch (Exception e) {
 
            e.printStackTrace();
 
        }
 
        return null;
 
    }
 
    public static long random(long begin,long end){
 
        long rtn = begin + (long)(Math.random() * (end - begin));
 
        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
 
        if(rtn == begin || rtn == end){
 
            return random(begin,end);
 
        }
 
        return rtn;
 
    }

}
