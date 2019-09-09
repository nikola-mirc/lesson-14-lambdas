package exercises;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class _3_JobCandidateSelectorUsingLambdas {

	public static void main(String[] args) {

		// 1. Sort the candidates by salary requirements, low to high.

		Collections.sort(JobCandidate.jobCandidates, new Comparator<JobCandidate>() {

			@Override
			public int compare(JobCandidate jc1, JobCandidate jc2) {
				return jc1.getSalaryRequired() - jc2.getSalaryRequired();
			}
		});

		System.out.println(JobCandidate.jobCandidates);

		// 2. Filter out any candidates that have not been taught by me (June)
		// Hint: see the removeIf() method in the Collections class

		Predicate<? super JobCandidate> notThoughtByJune = jc -> {

			if ((jc.getTeacherName().toLowerCase().contains("joon")) || (jc.getTeacherName().toLowerCase().contains("june"))
					|| (jc.getTeacherName().toLowerCase().contains("clarke")) || (jc.getTeacherName().toLowerCase().contains("clark"))) {
				return true;
			}
			return false;
		};

		JobCandidate.jobCandidates.removeIf(notThoughtByJune);
		System.out.println(JobCandidate.jobCandidates);

	}

}