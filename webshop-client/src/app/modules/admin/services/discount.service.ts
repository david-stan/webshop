import { SEASON_DISCOUNTS_URL, CATEGORY_DISCOUNTS_URL } from './../../../config/api-paths';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  constructor(private http: HttpClient) { 
  }

  getAllSeasonDiscounts(): Observable<any> {
    return this.http.get(SEASON_DISCOUNTS_URL);
  }

  deleteSeasonDiscount(id: number): Observable<any> {
    return this.http.delete(`${SEASON_DISCOUNTS_URL}/${id}`);
  }

  getAllCategoryDiscounts(): Observable<any> {
    return this.http.get(CATEGORY_DISCOUNTS_URL);
  }

  deleteCategoryDiscount(id: number): Observable<any> {
    return this.http.delete(`${CATEGORY_DISCOUNTS_URL}/${id}`);
  }
}