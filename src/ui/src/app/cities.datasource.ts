import { DataSource } from '@angular/cdk/table';
import { CitiesListResponse, Cities } from './cities';
import { CollectionViewer } from '@angular/cdk/collections';
import { Observable, BehaviorSubject, of } from "rxjs";
import { CitiesService } from './cities.service';
import { catchError, finalize } from "rxjs/operators";

export class CitiesDataSource implements DataSource<Cities>{

private citiesSubject = new BehaviorSubject<Cities[]>([]);
private loadingSubject = new BehaviorSubject<boolean>(false);
private countSubject = new BehaviorSubject<number>(0);
public counter$ = this.countSubject.asObservable();

constructor(private citiesService: CitiesService) { }

    connect(collectionViewer: CollectionViewer): Observable<Cities[]> {
        return this.citiesSubject.asObservable();
    }

    disconnect(collectionViewer: CollectionViewer): void {
        this.citiesSubject.complete();
        this.loadingSubject.complete();
        this.countSubject.complete();
    }

    loadCities(pageNumber = 0, pageSize = 10) {
        this.loadingSubject.next(true);
        this.citiesService.listCities({ page: pageNumber, size: pageSize })
            .pipe(
                catchError(() => of([])),
                finalize(() => this.loadingSubject.next(false))
)
.subscribe((result: CitiesListResponse) => {
                this.citiesSubject.next(result.content);
                this.countSubject.next(result.totalElements);
            }
            );
    }

}
