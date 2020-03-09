package com.bitm.SeleniumMaven.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bitm.SeleniumMaven.DTO.Address;
import com.bitm.SeleniumMaven.DTO.CreditCard;
import com.bitm.SeleniumMaven.DTO.FlightFinderDTO;
import com.bitm.SeleniumMaven.DTO.LoginDTO;
import com.bitm.SeleniumMaven.DTO.Passengers;

	public class ExcelUtils {
		
		private static FileInputStream inputStream = null;
		private static Workbook workbook = null;

		private static Sheet getSheet(int sheetNo) throws IOException {
			// change the file location as per your computer
			File f = new File("src/main/java");
			File fs = new File(f, "data.xlsx");
			inputStream = new FileInputStream(new File(fs.getAbsolutePath()));
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(sheetNo);
			return sheet;
		}

		public static List<LoginDTO> getLoginData() throws IOException {
			List<LoginDTO> logindata = new ArrayList<LoginDTO>();
			DataFormatter formatter = new DataFormatter();
			// login is the first sheet in excel so getSheet parameter set to 0
			Iterator<Row> iterator = ExcelUtils.getSheet(0).iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				LoginDTO login = new LoginDTO();
				byte cellCounter = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellCounter) {
					case 0:
						login.setUsername(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 1:
						login.setPassword(formatter.formatCellValue(cell));
						break;
					default:
						break;
					}

				}
				logindata.add(login);
			}
			close();
			return logindata;
		}

		
	
		
		public static List<FlightFinderDTO> getFlightFinderData() throws IOException {
			List<FlightFinderDTO> FFdata = new ArrayList<FlightFinderDTO>();
			DataFormatter formatter = new DataFormatter();
			// login is the first sheet in excel so getSheet parameter set to 0
			Iterator<Row> iterator = ExcelUtils.getSheet(1).iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				FlightFinderDTO FFinder = new FlightFinderDTO();
				byte cellCounter = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellCounter) {
					case 0:
						FFinder.setPassengers(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 1:
						FFinder.setDeparting(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 2:
						FFinder.setMonth(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 3:
						FFinder.setDay(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 4:
						FFinder.setArriving(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 5:
						FFinder.setRmonth(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 6:
						FFinder.setRday(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 7:
						FFinder.setAirline(formatter.formatCellValue(cell));
						break;
					default:
						break;
					}

				}
				FFdata.add(FFinder);
			}
			close();
			return FFdata;
		}

		
		
		
		public static List<Passengers> getFlightBookingData() throws IOException {
			List<Passengers> FBdata = new ArrayList<Passengers>();
			DataFormatter formatter = new DataFormatter();
			// login is the first sheet in excel so getSheet parameter set to 0
			Iterator<Row> iterator = ExcelUtils.getSheet(2).iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				Passengers passenger=new Passengers();
				CreditCard card=new CreditCard();
	            Address deliveryAddress=new Address();
	            Address billingAddress=new Address();
				
				byte cellCounter = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellCounter) {
					case 0:
						passenger.setFirstName(cell.getStringCellValue());
						cellCounter++;
						break;
					case 1:
						passenger.setLastName(cell.getStringCellValue());
						cellCounter++;
						break;
					case 2:
						cellCounter++;
						break;
					case 3:
						cellCounter++;
						break;
					
					case 4:
						card.setNumber(String.valueOf(cell.getNumericCellValue()));
						cellCounter++;
						break;
					case 5:
						cellCounter++;
						break;
					case 6:
						cellCounter++;
						break;
					
					case 7:
						card.setFirstName(cell.getStringCellValue());
						cellCounter++;
						break;
					case 8:
						card.setMiddleName(cell.getStringCellValue());
						cellCounter++;
						break;
					case 9:
						card.setLastName(cell.getStringCellValue());
						cellCounter++;
						break;
					case 10:
						billingAddress.setAddress(cell.getStringCellValue());
						cellCounter++;
						break;
					case 11:
						billingAddress.setCity(cell.getStringCellValue());
						cellCounter++;
						break;
					case 12:
						billingAddress.setState(cell.getStringCellValue());
						cellCounter++;
						break;
					case 13:
						billingAddress.setPostalCode(cell.getStringCellValue());
						cellCounter++;
						break;
					case 14:
						cellCounter++;
						break;
					case 15:
						deliveryAddress.setAddress(cell.getStringCellValue());
						cellCounter++;
						break;
					case 16:
						deliveryAddress.setCity(cell.getStringCellValue());
						cellCounter++;
						break;
					case 17:
						deliveryAddress.setState(cell.getStringCellValue());
						cellCounter++;
						break;
					case 18:
						deliveryAddress.setPostalCode(cell.getStringCellValue());
						cellCounter++;
						break;
					case 19:
						cellCounter++;
						break;
					default:
						break;
					}               
	                 
	            }
						
					
				passenger.setCard(card);
	            passenger.setBillingAddress(billingAddress);
	            passenger.setDeliveryAddress(deliveryAddress);
	            FBdata.add(passenger);
	        }
	        close();
			return FBdata;
		}

		private static void close() throws IOException{
			workbook.close();
			inputStream.close();
			
		}
		
	
	}
	

