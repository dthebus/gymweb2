/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.repository;

import com.dthebus.gymweb.domain.EnergyDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author darren
 */
@Repository
public interface EnergyDrinkRepository extends JpaRepository<EnergyDrink, Long>{
    
}
