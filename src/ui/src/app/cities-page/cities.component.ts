import { Component, ViewChild } from '@angular/core';
import { CitiesDataSource } from '../cities.datasource';
import { MatPaginator } from '@angular/material/paginator';
import { CitiesService } from '../cities.service';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-i-page',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesPage {

  displayedColumns = ['id', 'name'];
  citiesDatasource: CitiesDataSource;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private citiesService: CitiesService) { }

    ngOnInit() {
      this.citiesDatasource = new CitiesDataSource(this.citiesService);
      this.citiesDatasource.loadCities();
    }

    ngAfterViewInit() {
      this.citiesDatasource.counter$
        .pipe(
          tap((count) => {
            this.paginator.length = count;
          })
  )
  .subscribe();

      this.paginator.page
        .pipe(
          tap(() => this.loadCities())
  )
  .subscribe();
    }

    loadCities() {
      this.citiesDatasource.loadCities(this.paginator.pageIndex, this.paginator.pageSize);
    }

}
