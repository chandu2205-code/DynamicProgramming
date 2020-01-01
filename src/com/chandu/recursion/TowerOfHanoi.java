package com.chandu.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *Tower of Hanoi is mathematical game . 3 pegs , Source, Destination, Extra marked as S,D,E
 *and there are n discs , each of different size, which can be inserted into any three pegs
 * <ul>
 *     <li>All discs are initially inserted into source peg(smallest to top)</li>
 *     <li>We have to move all pegs from source to destination</li>
 *     <li><b>Restrictions</b></li>
 *     <li>Only one disc can be moved at a time</li>
 *     <li>At any point we should never place larger disc on top of smaller disc</li>
 *     <li><b>
 *         Write a function that accepts characters representing three rods (S,D & E)
 *         and number of discs (n) , and print movement of discs between pegs such
 *         that all discs are moved from initial state (S) to final state (D)
 *     </b></li>
 * </ul>
 */
public class TowerOfHanoi {
    private static int functionCallCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int discNumber = Integer.parseInt(br.readLine());
        towerOfHanoi(discNumber,'A','B','C');
        System.out.println(String.format("Number of function calls for %d discs is %d",discNumber,functionCallCount));
    }

    private static void towerOfHanoi(int discNumber, char source, char auxiliary, char destination) {
        functionCallCount++;
        if(discNumber == 1) {
            System.out.println(String.format("Move disc %d from %s to %s",discNumber,source,destination));
            return;
        }
        towerOfHanoi(discNumber-1,source,destination,auxiliary);
        System.out.println(String.format("Move disc %d from %s to %s",discNumber,source,destination));
        towerOfHanoi(discNumber-1,auxiliary,source,destination);
    }
}
