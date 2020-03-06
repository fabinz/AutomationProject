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

import com.bitm.SeleniumMaven.DTO.FlightBookingDTO;
import com.bitm.SeleniumMaven.DTO.FlightFinderDTO;
import com.bitm.SeleniumMaven.DTO.LoginDTO;

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

		
		
		
		public static List<FlightBookingDTO> getFlightBookingData() throws IOException {
			List<FlightBookingDTO> FBdata = new ArrayList<FlightBookingDTO>();
			DataFormatter formatter = new DataFormatter();
			// login is the first sheet in excel so getSheet parameter set to 0
			Iterator<Row> iterator = ExcelUtils.getSheet(2).iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				FlightBookingDTO fbooking = new FlightBookingDTO();
				byte cellCounter = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellCounter) {
					case 0:
						fbooking.setFname(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 1:
						fbooking.setLname(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 2:
						fbooking.setMeal(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 3:
						fbooking.setCcard(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 4:
						fbooking.setNumber(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 5:
						fbooking.setEdate(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 6:
						fbooking.setEyear(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 7:
						fbooking.setFrstname(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 8:
						fbooking.setMidname(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 9:
						fbooking.setLastname(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 10:
						fbooking.setBilladd(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 11:
						fbooking.setCity(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 12:
						fbooking.setState(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 13:
						fbooking.setPostalcode(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 14:
						fbooking.setCountry(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 15:
						fbooking.setDeladd(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 16:
						fbooking.setDelcity(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 17:
						fbooking.setDelstate(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 18:
						fbooking.setDelpost(formatter.formatCellValue(cell));
						cellCounter++;
						break;
					case 19:
						fbooking.setDelcountry(formatter.formatCellValue(cell));
						
						break;
					case 20:
						fbooking.setDelcity(formatter.formatCellValue(cell));
						break;
						
					default:
						break;
					}

				}
				FBdata.add(fbooking);
			}
			close();
			return FBdata;
		}

		private static void close() throws IOException{
			workbook.close();
			inputStream.close();
			
		}
		
	
	}

