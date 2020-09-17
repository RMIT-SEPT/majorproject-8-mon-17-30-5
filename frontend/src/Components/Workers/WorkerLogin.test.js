import React from 'react';
import { shallow } from 'enzyme';
import WorkerLogin from './WorkerLogin';
import Enzyme from "enzyme";




describe('Test cases for testing WorkerLogin', () => {
    let wrapper;
    test('username check', () => {
        wrapper = shallow(<WorkerLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'Mina' } });
        expect(wrapper.state('username')).toEqual('Mina');
    })

    it('password check', () => {
        wrapper = shallow(<WorkerLogin />);
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        expect(wrapper.state('password')).toEqual('1234');
    })

    it('WorkerLogin check for correct login information', () => {
        wrapper = shallow(<WorkerLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'Mina' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '1234' } });
        wrapper.find('button').simulate('click');
        expect(wrapper.state('hasWorkerLoginFailed')).toBe(true);
    })

    it('WorkerLogin check for wrong login information', () => {
        wrapper = shallow(<WorkerLogin />);
        wrapper.find('input[type="text"]').simulate('change', { target: { name: 'username', value: 'Mina' } });
        wrapper.find('input[type="password"]').simulate('change', { target: { name: 'password', value: '123' } });
        wrapper.find('button').simulate('click');
        expect(wrapper.state('hasWorkerLoginFailed')).toBe(false);
    })
})